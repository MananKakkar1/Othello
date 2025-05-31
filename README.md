# 🟩 Othello Game

## 📝 Project Overview

Othello is a classic 8x8 board game where two players compete to capture the most discs by the end of the game. This project is a **Java-based, object-oriented implementation** of Othello, designed to be clean, modular, and easy to understand.

## 🚀 What’s Implemented

- **Game Logic & Rules** 🧠  
  All standard Othello rules are faithfully implemented, including:
  - Legal move detection
  - Flipping opponent’s discs
  - Passing when no valid moves are available
  - Game end detection and winner calculation

- **Board Representation** 🟫  
  The game board is represented as an 8x8 grid, with clear tracking of black and white pieces and empty squares.

- **Turn Management** 🔁  
  Players alternate turns, with the code enforcing move validity and handling pass turns if necessary.

- **Console UI** 💻  
  The game runs in the terminal, displaying the board after every move and prompting players for their next move.

- **Modular Structure** 🧩  
  The code is organized into classes like `Board`, `Game`, `Player`, and `Move` to separate responsibilities and keep logic clean.

## 🎮 How It Works

1. **Startup**: The game launches and prints an initial board with 2 black and 2 white discs at the center.
2. **Player Turns**: Players are prompted to enter their move (row, column). Invalid moves are rejected with feedback.
3. **Move Resolution**: The game checks for flips in all directions, updates the board, and switches turns.
4. **Passing**: If a player has no valid moves, their turn is automatically passed.
5. **End of Game**: When neither player can move, the board is counted and the winner is announced.

---

Enjoy the game, and feel free to explore the source code to see how Othello is built under the hood! 😄
