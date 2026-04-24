I can't directly send a file for download, but here's how you can get it onto your machine:

1. **Copy the content** from the code block below.
2. **Paste** it into a new text file.
3. **Save** the file as `README.md` (make sure the extension is `.md`, not `.txt`).

Here's the content again (same as above):

```markdown
# 21 - A Blackjack‑Inspired Card Game

A console‑based implementation of the “21” minigame from *Resident Evil 7*, built in Java.  
The player faces an AI opponent in an alternating‑turn duel, using a custom numbered deck (cards 1 to 11) and an adaptive CPU decision‑maker.

## Features

- **Numbered deck** – 11 cards (values 1–11), shuffled each round, auto‑resets when empty.
- **Alternating turns** – Player and CPU take turns hitting or standing after the initial two cards.
- **Smart CPU** – Uses a three‑tier strategy based on the player’s **visible total** (all cards except the first hidden card):
  - Visible ≤ 6 → stands at 10
  - Visible 7–9 → stands at 14
  - Visible ≥ 10 → stands at 17
- **Bust & win detection** – Immediate bust on both sides, final evaluation includes blackjack (21), ties, and higher hand.
- **Clean separation of concerns** – Game logic, AI, and evaluation are in separate classes (`Game`, `CpuDecisionMaker`, `GameEvaluator`).

## How to Run

1. **Compile** all `.java` files (from the root directory):
   ```bash
   javac *.java
   ```
2. **Run** the game:
   ```bash
   java Main
   ```

No external libraries are required – pure Java.

## How to Play

1. You and the CPU each receive two cards (one of your cards is face‑down, hidden from the CPU).
2. Your visible cards are shown; the CPU’s first card is hidden.
3. On your turn:
   - **1 – Hit** → draw a card. Bust if your total exceeds 21.
   - **2 – Stand** → end your turn.
4. After you stand, the CPU takes one or more turns until it stands or busts.
5. The round ends when both stand or someone busts. The higher total (≤21) wins.

## Project Structure

| File | Responsibility |
|------|----------------|
| `Main.java` | Launches the game. |
| `Game.java` | Orchestrates the round flow (dealing, turn loop, display). |
| `NumberedDeck.java` | Manages the deck of 1–11, shuffling, dealing, resetting. |
| `Player.java` | Holds a hand, calculates total, draws cards, reveals visible sum. |
| `CpuDecisionMaker.java` | Encapsulates the AI threshold logic. |
| `GameEvaluator.java` | Compares final hand values and returns a `GameResult`. |
| `GameResult.java` | Enum for possible outcomes. |

## Example Console Output

```
CPU hand: [5, 9]
Your hand: [4, 7]
Your hand value: 11
1 - Hit
2 - Stand
Enter choice: 1
You drew a card.
...
--- Final Hands ---
Your hand: [4, 7, 3]
Your total: 14
CPU hand: [2, 5, 9]
CPU total: 16
You lose!
```

## Future Plans

- **Graphical interface** – Port the game to **libGDX** with card images, animations, and a polished UI.
- **Trump cards** – Introduce unique cards with special abilities (destroy opponent’s card, double points, etc.).
- **Advanced AI** – Deck composition tracking and probabilistic decision‑making.

## Acknowledgments

Inspired by the “21” DLC from *Resident Evil 7*. Built as a learning project for clean object‑oriented design and game logic separation.

---

**Enjoy the game – and don’t bust!**
```

To save it on most operating systems:
- **Windows**: Notepad → paste → "Save as" → select "All files" → name it `README.md`.
- **macOS / Linux**: Any text editor → paste → save as `README.md`.

Would you like me to adjust anything in the README before you save it?
