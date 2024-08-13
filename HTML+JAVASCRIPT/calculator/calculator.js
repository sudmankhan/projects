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

let evaluationStack = [];

const display = document.querySelector(".view");

function evaluate(evaluationStack) {
  const operation = evaluationStack[1];
  const firstNum = +evaluationStack[0];
  const secondNum = +evaluationStack[2];
  evaluationStack.splice(0,evaluationStack.length)
  console.log(evaluationStack)
  display.textContent = "0";
  switch(operation) {
    case "+":
      return add(firstNum, secondNum);
    case "-":
      return subtract(firstNum, secondNum);
    case "*":
      return multiply(firstNum, secondNum);
      // Math.round((multiply(firstNum, secondNum) + Number.EPSILON) * 100) / 100;
    case "/":
      return divide(firstNum, secondNum);
      //Math.round((divide(firstNum, secondNum) + Number.EPSILON) * 1000) / 1000;
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
    if (item.id === "clear") {
      display.textContent = "0";
      evaluationStack.splice(0,evaluationStack.length)
    }
    

    // negate
    else if (item.id === "neg") {
      if(display.textContent !== "0") {
        if (display.textContent[0] !== "-") display.textContent = "-" + display.textContent;
        else if (display.textContent[0] === "-") display.textContent = display.textContent.slice(1);
      }
      if (evaluationStack.length == 1) evaluationStack[0] = display.textContent;
      // console.log(evaluationStack);
      if (evaluationStack.length == 3) evaluationStack[2] = display.textContent;
      console.log(evaluationStack);
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
    console.log(evaluationStack);
    if (evaluationStack.length == 3) {
      evaluationStack.push(evaluate(evaluationStack));
      display.textContent = evaluationStack[0]; 
      console.log(evaluationStack);
      if (item.id !== "equals") evaluationStack.push(item.textContent);
    }
    // console.log(evaluationStack);
  }
);
item.addEventListener("mouseover", () => {item.style.backgroundColor = "rgb(255, 225, 162)";});
item.addEventListener("mouseout", () => {item.style.backgroundColor = "rgb(255, 174, 0)";});
});

