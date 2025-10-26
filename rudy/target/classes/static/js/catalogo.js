document.addEventListener("DOMContentLoaded", function () {
    fetch("/productos")
        .then(response => response.json())
        .then(data => {
            const contenedor = document.getElementById("catalogo");
            const mensaje = document.createElement("div");
            mensaje.id = "mensaje";
            mensaje.style.margin = "10px 0";
            mensaje.style.fontWeight = "bold";
            contenedor.parentNode.insertBefore(mensaje, contenedor);


            data.forEach(producto => {
                const div = document.createElement("div");
                div.className = "producto";
                div.innerHTML = `
                    <img src="${producto.imagen}" alt="${producto.nombre}">
                    <h3>${producto.nombre}</h3>
                    <p>Q${producto.precio}</p>
                    <label for="cantidad-${producto.codigo}">Cantidad:</label>
                    <input type="number" id="cantidad-${producto.codigo}" min="1" value="1" />
                    <br>
                    <button onclick="agregarAlCarrito('${producto.codigo}')">AGREGAR</button>
                `;
                contenedor.appendChild(div);
            });
        })
        .catch(error => console.error("Error al cargar productos:", error));
});

function agregarAlCarrito(codigo) {
    const inputCantidad = document.getElementById(`cantidad-${codigo}`);
    const cantidad = parseInt(inputCantidad.value);
    const mensaje = document.getElementById("mensaje");
    mensaje.textContent = "";
    mensaje.style.color = "green";

    if (isNaN(cantidad) || cantidad < 1) {
        mensaje.style.color = "red";
        mensaje.textContent = "Por favor ingresa una cantidad válida.";
        return;
    }

    fetch("/carrito/agregar", {
        method: "POST",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded"
        },
        body: `codigo=${encodeURIComponent(codigo)}&cantidad=${cantidad}`
    })
    .then(response => {
        if (response.ok) {
            mensaje.style.color = "green";
            mensaje.textContent = "Producto agregado al carrito.";
        } else {
            mensaje.style.color = "red";
            mensaje.textContent = "Error al agregar producto.";
        }
    })
    .catch(error => {
        console.error("Error al agregar al carrito:", error);
        mensaje.style.color = "red";
        mensaje.textContent = "Error de conexión.";
    });
}

