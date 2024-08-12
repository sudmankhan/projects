const add = function(a, b) {
	return a + b;
};

const subtract = function(a, b) {
	return a - b;
};

const multiply = function(a, b) {
  return a * b;
};

const divide = function(a, b) {
  return a/b;
};

const evaluationStack = [];

const display = document.querySelector(".view");

function evaluate(evaluationStack) {
  const operation = evaluationStack[1];
  const firstNum = +evaluationStack[0];
  const secondNum = +evaluationStack[2];
  evaluationStack = [];
  console.log(evaluationStack)
  display.textContent = "0";
  switch(operation) {
    case "+":
      return add(firstNum, secondNum);
    case "-":
      return subtract(firstNum, secondNum);
    case "*":
      return multiply(firstNum, secondNum);
    case "/":
      return divide(firstNum, secondNum);
  }
}

// number buttons
const nums = document.querySelectorAll(".num");
nums.forEach((item) => {
  item.addEventListener("click", () => {
    if (evaluationStack.length == 2 || evaluationStack.length == 0) display.textContent = "0";
    if(display.textContent === "0") {
      display.textContent = item.textContent;
    } else {
      display.textContent += item.textContent;
    }
    // if (display.textContent.length > 14) {
    //   display.textContent = display.textContent.slice(0, 14);
    // }
    if (evaluationStack.length == 0) evaluationStack.push(display.textContent);
    console.log(evaluationStack);
    if (evaluationStack.length == 1) evaluationStack[0] = display.textContent;
    console.log(evaluationStack);
    if (evaluationStack.length == 2) evaluationStack.push(display.textContent);
    console.log(evaluationStack);
    if (evaluationStack.length == 3) evaluationStack[2] = display.textContent;
    console.log(evaluationStack);
  }
);
  item.addEventListener("mouseover", () => {item.style.backgroundColor = "rgba(201, 201, 201)";});
  item.addEventListener("mouseout", () => {item.style.backgroundColor = "rgba(117, 117, 117)";});
});

//function buttons
const funcs = document.querySelectorAll(".func");
funcs.forEach((item) => {
  item.addEventListener("click", () => {
    // clear
    if (item.id === "clear") display.textContent = "0";

    // negate
    else if (item.id === "neg") {
      if(display.textContent !== "0") {
        if (display.textContent[0] !== "-") display.textContent = "-" + display.textContent;
        else if (display.textContent[0] === "-") display.textContent = display.textContent.slice(1);
      }
    }

    // percent
    else if (item.id === "percent") {
      if(display.textContent !== "0") display.textContent = +display.textContent / 100;
    }
  }
);
item.addEventListener("mouseover", () => {item.style.backgroundColor = "rgb(0, 156, 180)";});
item.addEventListener("mouseout", () => {item.style.backgroundColor = "rgb(0, 110, 126)";});
});

// operation buttons 
const ops = document.querySelectorAll(".operation");
ops.forEach((item) => {
  item.addEventListener("click", () => {
    // if (item.style.backgroundColor !== "rgb(255, 225, 162)") {
    //   item.style.backgroundColor = "rgb(255, 225, 162)";
    // }
    // else if (item.style.backgroundColor !== "rgb(255, 174, 0)") {
    //   item.style.backgroundColor = "rgb(255, 174, 0)";
    // }

    // console.log(item.textContent);
    if (evaluationStack.length == 1) evaluationStack.push(item.textContent);
    if (item.id === "equals" && evaluationStack.length == 3) display.textContent = evaluate(evaluationStack); 
    // console.log(evaluationStack);
  }
);
// item.addEventListener("mouseover", () => {item.style.backgroundColor = "rgb(255, 225, 162)";});
// item.addEventListener("mouseout", () => {item.style.backgroundColor = "rgb(255, 174, 0)";});
});

