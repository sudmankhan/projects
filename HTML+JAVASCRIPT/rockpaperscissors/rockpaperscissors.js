let humanScore = 0;
let computerScore = 0;

function getComputerChoice() {
    let rand = parseInt(Math.random() * 3)
    if (rand == 0) {
        return "rock"
    } else if (rand == 1) {
        return "paper"
    } else if (rand == 2) {
        return "scissors"
    }
} 

function getHumanChoice() {
    let choice = prompt("Rock, Paper, or Scissors?").toLowerCase();
    while (choice !== "rock" &&
           choice !== "paper" &&
           choice !== "scissors") {
            choice = prompt("Rock, Paper, or Scissors?").toLowerCase();
           }
    return choice;
}

function playRound(humanChoice, computerChoice) {
    // let humanChoice = getHumanChoice();
    // let computerChoice = getComputerChoice();
    if (humanChoice == "rock" && computerChoice == "rock") return "Tie!";
    else if (humanChoice == "rock" && computerChoice == "paper") {
        computerScore++;
        return "You lose! Paper beats Rock";
    }
    else if (humanChoice == "rock" && computerChoice == "scissors") {
        humanScore++;
        return "You win! Rock beats Scissors";
    }
    else if (humanChoice == "paper" && computerChoice == "rock") {
        humanScore++;
        return "You win! Paper beats Rock";
    }
    else if (humanChoice == "paper" && computerChoice == "paper") return "Tie!";
    else if (humanChoice == "paper" && computerChoice == "scissors") {
        computerScore++;
        return "You lose! Scissors beat Paper";
    }
    else if (humanChoice == "scissors" && computerChoice == "rock") {
        computerScore++;
        return "You lose! Rock beats Scissors";
    }
    else if (humanChoice == "scissors" && computerChoice == "paper") {
        humanScore++;
        return "You win! Scissors beat Paper";
    }
    else if (humanChoice == "scissors" && computerChoice == "scissors") return "Tie";
}

// function playGame() {
//     for(let i = 0; i < 5; i++) {
//         console.log(playRound());
//     }
//     if(humanScore > computerScore) {
//         console.log("Human wins!")
//     } else if (computerScore > humanScore) {
//         console.log("Computer wins!")
//     } else {
//         console.log("Tie!")
//     }
// }

// console.log(getComputerChoice());
// console.log(getHumanChoice());
// console.log(playRound(getHumanChoice(), getComputerChoice()));
// console.log("Computer Score: " + computerScore);
// console.log("Human Score: " + humanScore);

const container = document.querySelector("#container");
const div = document.createElement("div");
const humanScoreLabel = document.createElement("h2");
const computerScoreLabel = document.createElement("h2");
const winner = document.createElement("h1");
const humanChoiceLabel = document.createElement("p");
const computerChoiceLabel = document.createElement("p");

humanScoreLabel.textContent = "Human Score: " + humanScore;
computerScoreLabel.textContent = "Computer Score: " + computerScore;

// div.style.color = "red";
div.style.fontFamily = "DejaVu Sans Mono, monospace";

div.appendChild(humanScoreLabel);
div.appendChild(computerScoreLabel);
div.appendChild(humanChoiceLabel);
div.appendChild(computerChoiceLabel);
div.appendChild(winner);
container.appendChild(div);

const buttons = document.querySelectorAll("button");
buttons.forEach((button) => {button.addEventListener("click", () => {
    if (humanScore != 5 && computerScore != 5) {
        humanChoice = button.id;
        computerChoice = getComputerChoice();
        playRound(humanChoice, computerChoice);
        humanChoiceLabel.textContent = "Human Choice: " + humanChoice[0].toUpperCase() + humanChoice.slice(1);
        computerChoiceLabel.textContent = "Computer Score: " + computerChoice[0].toUpperCase() + computerChoice.slice(1);;

        humanScoreLabel.textContent = "Human Score: " + humanScore;
        computerScoreLabel.textContent = "Computer Score: " + computerScore;
        if(humanScore == 5) {
            winner.textContent = "Human Wins!";
        } else if (computerScore == 5) {
            winner.textContent = "Computer Wins!";
        }
    } 
});
});

// div.appendChild(humanScoreLabel);
// div.appendChild(computerScoreLabel);
// div.appendChild(winner);
// container.appendChild(div);

// const r = document.querySelector("#r");
// const p = document.querySelector("#p");
// const s = document.querySelector("#s");
// r.addEventListener("click", alert("Hello World!"));
// p.addEventListener("click", playRound("paper", getComputerChoice()));
// s.addEventListener("click", playRound("scissors", getComputerChoice()));
// console.log("Computer Score: " + computerScore);
// console.log("Human Score: " + humanScore);
// while(humanScore || computerScore != 5) {
    
// }
// // playGame();