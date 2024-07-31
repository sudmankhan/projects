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

const buttons = document.querySelectorAll("button");
buttons.forEach((button) => {button.addEventListener("click", () => {
    // alert(button.id);
    if(button.id == "r") playRound("rock", getComputerChoice());
    if(button.id == "p") playRound("paper", getComputerChoice());
    if(button.id == "s") playRound("scissors", getComputerChoice());
    console.log("Computer Score: " + computerScore);
    console.log("Human Score: " + humanScore);
});
});

// const r = document.querySelector("#r");
// const p = document.querySelector("#p");
// const s = document.querySelector("#s");
// r.addEventListener("click", alert("Hello World!"));
// p.addEventListener("click", playRound("paper", getComputerChoice()));
// s.addEventListener("click", playRound("scissors", getComputerChoice()));
console.log("Computer Score: " + computerScore);
console.log("Human Score: " + humanScore);
// playGame();