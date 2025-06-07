# 🕊️ White Paper: Simulation of Papal Conclave in Java

## 🧩 Overview

This project simulates a **Papal Conclave**, the process by which the **College of Cardinals** elects a new Pope. The implementation models realistic voting dynamics using **object-oriented programming principles** in Java, while avoiding multithreading and advanced concurrency primitives.

## 🎯 Goals

- Represent each cardinal as an independent decision-making object.
- Simulate rounds of voting where cardinals vote based on preferences and influence.
- Elect a Pope once the **two-thirds majority (90 out of 135 votes)** is achieved.
- Reflect realistic election dynamics: early consensus around 1–2 strong candidates and some randomness.

## 🛠️ Implementation

### 👤 Cardinal Class

Each `Cardinal` object has:

- A name.
- A vote (the name of the cardinal they voted for).
- A method `decideVote()` that chooses a candidate based on weighted probabilities.

**Example of weighted vote decision:**

```java
// 60% → Leader1
// 30% → Leader2
// 10% → Random candidate
