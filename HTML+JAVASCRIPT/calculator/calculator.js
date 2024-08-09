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

// const nums = document.querySelectorAll("#num");
// nums.forEach((item) => {item.addEventListener("click", () => {
//   console.log("monkey");
// });
// });

console.log(add(3,4));
console.log(subtract(3,4));
console.log(multiply(3,4));
console.log(divide(12,4));

const display = document.querySelector(".view");
const nums = document.querySelectorAll(".num");
nums.forEach((item) => {
  item.addEventListener("click", () => {
    if(display.textContent === "0") {
      display.textContent = item.textContent;
    } else {
      display.textContent += item.textContent;
    }
    if (display.textContent.length > 14) {
      display.textContent = display.textContent.slice(0, 14);
    }
  }
);
  item.addEventListener("mouseover", () => {item.style.backgroundColor = "rgb(201, 201, 201)";});
  item.addEventListener("mouseout", () => {item.style.backgroundColor = "rgb(117, 117, 117)";});
});


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


