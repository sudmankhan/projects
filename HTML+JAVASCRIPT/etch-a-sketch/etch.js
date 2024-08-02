const container = document.querySelector("#container");

for (let i = 0; i < 16; i++) {
    const row = document.createElement("div");
    // row.id = "row";
    // row.textContent = "row";
    // container.appendChild(row);
    for (let j = 0; j < 16; j++) {
        const item = document.createElement("div");
        // col.id = "col";
        // item.textContent = "item";
        item.style.height = "56px";
        // item.style.width = "50px";
        row.appendChild(item);
    }
    container.appendChild(row);
}