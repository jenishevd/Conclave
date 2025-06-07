🕊️ White Paper: Simulation of Papal Conclave in Java
🧩 Overview
This project simulates a Papal Conclave, the process by which the College of Cardinals elects a new Pope. The implementation models realistic voting dynamics using object-oriented programming principles in Java.

🎯 Goals
Represent each cardinal as an independent decision-making object.

Simulate rounds of voting where cardinals vote based on preferences and influence.

Elect a Pope once the two-thirds majority (90 out of 135 votes) is achieved.

Reflect realistic election dynamics: early consensus around 1–2 strong candidates and some randomness.

🛠️ Implementation
👤 Cardinal Class
Each Cardinal object has:

A name.

A vote (the name of the cardinal they voted for).

A method decideVote() that chooses a candidate based on weighted probabilities.

java
Copy
Edit
// Example of weighted vote decision
60% → Leader1  
30% → Leader2  
10% → Random candidate
🏛️ Conclave Class
The Conclave manages:

A list of 135 cardinals.

Two leaders chosen randomly at the beginning.

Iterative voting rounds.

Tallying and checking for a two-thirds majority.

🔁 Voting Loop
Each round:

Cardinals vote.

Votes are tallied.

If a candidate receives ≥ 90 votes, they are declared the Pope.

Most simulations result in a Pope being elected within 3–5 rounds.

🔎 Design Choices
No concurrency: The simulation is single-threaded for simplicity and clarity.

Deterministic structure: Fixed leaders and probabilistic support simulate factional dynamics.

Extendable design: Easily extendable to support dynamic candidate influence, persuasion phases, or speech rounds.

🧠 Possible Extensions
Simulate cardinal alliances and negotiations.

Model personality traits and historical context.

Introduce external factors (e.g., political pressure, age bias).

Switch to multithreaded model using wait/notify for realistic inter-thread communication.

📦 Technologies Used
Java 17

Pure OOP (no synchronized, no streams, no multithreading)

Console output for result tracking

✅ Example Output
yaml
Copy
Edit
Leader 1: Cardinal_42
Leader 2: Cardinal_91

--- Round 1 ---
Votes: Cardinal_42 (83), Cardinal_91 (40), ...

--- Round 2 ---
Votes: Cardinal_42 (92) → Elected as Pope!
🏁 Conclusion
This simulation captures the essence of the Papal Conclave using foundational Java programming principles. It provides a platform for learning about object-oriented design, probability-based simulation, and election dynamics in a structured, extensible way.

