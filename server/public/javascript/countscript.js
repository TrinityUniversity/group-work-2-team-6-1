console.log("javascript is working");

const countRoute = document.getElementById("countRoute").value;
const socketRoute = document.getElementById("socketRoute").value;
const count = document.getElementById("count");

function increaseCount() {
    fetch(countRoute).then(response => {
        return response.json();
    }).then(json => {
        count.innerHTML = json;
    });
}

const socketRoute = document.getElementById("socketRoute").value;
const ws = new WebSocket(socketRoute.replace("http", "ws"))

ws.onopen = (event) => socketRoute.send("New user connected")