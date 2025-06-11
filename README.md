# 🕊️ Papal Conclave Simulation in Java

[![Java](https://img.shields.io/badge/Java-17%2B-red.svg)](https://www.oracle.com/java/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Build Status](https://img.shields.io/badge/build-passing-brightgreen.svg)]()

## 🧩 Overview

This project simulates a **Papal Conclave**, the secretive election process in which the **College of Cardinals** elects a new Pope. The model is implemented in **pure Java**, modeling realistic voting behavior among **135 cardinals** over up to **6 voting rounds**. The simulation emphasizes political dynamics such as popularity, loyalty, and randomness.

## 🎯 Goals

- ✅ Model each cardinal as an independent, decision-making agent.
- ✅ Simulate up to 6 rounds of voting, influenced by voting trends.
- ✅ Elect a Pope once a **two-thirds majority (≥ 90 votes)** is achieved.
- ✅ Reflect real-world political shifts: alliances, popularity, indecision.

---

## 🛠️ Implementation

### 👤 `Cardinal` Class

Each `Cardinal` has:
- A `name`
- A `vote` (name of the cardinal they voted for)
- A `vote()` method that selects a candidate based on election stage

**Voting Strategy:**
```java
if (roundNumber <= 2) {
    // 60% → Leader1
    // 30% → Leader2
    // 10% → Random third candidate
} else {
    // 80% → Popular candidate from last round
    // 20% → One of the original leaders
}
