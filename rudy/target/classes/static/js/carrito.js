
document.addEventListener("DOMContentLoaded", function () {
    fetch("/carrito/resumen")
        .then(response => response.json())
        .then(data => {
            const contenedor = document.getElementById("carrito");
            data.forEach(item => {
                const div = document.createElement("div");
                div.textContent = `${item.nombreProducto} x${item.cantidad} = Q${item.subtotal}`;
                contenedor.appendChild(div);
            });
        })
        .catch(error => {
            console.error("Error al cargar el carrito:", error);
        });
});
