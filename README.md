## Eurovision 2024 Jury Voting Simulation

In the Eurovision 2024 contest, 37 countries participated, and 26 countries qualified for the final.  
Each of the 37 countries voted for 10 out of the 26 finalists, assigning the following points:  
**1, 2, 3, 4, 5, 6, 7, 8, 10, and 12**.  
This program simulates the jury voting process.

### Voting Procedure
- The countries vote in a random order.
- For each country that votes, a numbered list of the 26 finalist countries is displayed.
- The user is asked to input the index (from the list) of the country that receives each point value (starting from 1 up to 12, skipping 9 and 11).
- The user must enter the index of the chosen country in the correct order of points (1 to 12).

### Error Handling
Three types of errors are detected during voting:
1. **Index out of bounds** — the selected index is not within the valid range.
2. **Self-voting** — a country attempts to vote for itself.
3. **Duplicate voting** — a country is selected more than once.

Each voting input is validated to ensure the above rules are not violated.
