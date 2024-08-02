const container = document.querySelector("#container");

const sliderbox = document.getElementById("slidercontainer");
const slider = document.getElementById("slider");
slider.style.height = "50px";
slider.style.width = "400px";

const value = document.getElementById("value");
value.textContent = slider.value;

function createGrid(size) {
    for (let i = 0; i < size; i++) {
        const row = document.createElement("div");
        row.id = "row"
        for (let j = 0; j < size; j++) {
            const item = document.createElement("div");
            item.id = "item";
            const boxSize = 890/size;
            item.style.height = boxSize + "px";
            item.style.width = boxSize + "px";
            row.appendChild(item);
        }
        container.insertBefore(row, slidecontainer);
    }
}

createGrid(slider.value);

const items = document.querySelectorAll("#item");
items.forEach((item) => {item.addEventListener("mouseover", () => {
    item.style.backgroundColor = "black";
    if(item.style.opacity < 1.0) item.style.opacity = +item.style.opacity + 0.1;
});
});

slider.oninput = () => {
    console.log(slider.value);
    value.textContent = slider.value;
    const rows = document.querySelectorAll("#row");
    rows.forEach((row) => {
        row.remove();
    });
    createGrid(slider.value);
    const items = document.querySelectorAll("#item");
    items.forEach((item) => {item.addEventListener("mouseover", () => {
        item.style.backgroundColor = "black";
        if(item.style.opacity < 1.0) item.style.opacity = +item.style.opacity + 0.1;
    });
    });
}

// const button = document.createElement("button");
// button.style.height = "100px";
// button.style.width = "100px";
// container.appendChild(button);


// createGrid(16);
