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
    // humanChoice = getHumanChoice();
    // computerChoice = getComputerChoice();
    if (humanChoice == "rock" && computerChoice == "rock") return "Tie!";
    else if (humanChoice == "rock" && computerChoice == "paper") return "You lose! Paper beats Rock";
    else if (humanChoice == "rock" && computerChoice == "scissors") return "You win! Rock beats Scissors";
    else if (humanChoice == "paper" && computerChoice == "rock") return "You win! Paper beats Rock";
    else if (humanChoice == "paper" && computerChoice == "paper") return "Tie!";
    else if (humanChoice == "paper" && computerChoice == "scissors") return "You lose! Scissors beat Paper";
    else if (humanChoice == "scissors" && computerChoice == "rock") return "You lose! Rock beats Scissors";
    else if (humanChoice == "scissors" && computerChoice == "paper") return "You win! Scissors beat Paper";
    else if (humanChoice == "scissors" && computerChoice == "scissors") return "Tie";
}

// console.log(getComputerChoice());
// console.log(getHumanChoice());
console.log(playRound(getHumanChoice(), getComputerChoice()));
// console.log(getComputerChoice());
// console.log(getHumanChoice());
