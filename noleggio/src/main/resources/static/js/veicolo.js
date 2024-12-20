
function goToDetailPage(id, name, description, image) {
    
    localStorage.setItem('vehicleId', id);
    localStorage.setItem('vehicleName', name);
    localStorage.setItem('vehicleDescription', description);
    localStorage.setItem('vehicleImage', image);

    
    window.location.href = 'veicolo.html'; 
}

// Controlliamo se siamo nella pagina principale (index.html)
if (window.location.pathname === '/index.html') {
    const images = document.querySelectorAll('.carousel img');
    
    images.forEach(img => {
        img.addEventListener('click', function() {
            const id = this.getAttribute('data-id');
            const name = this.getAttribute('data-name');
            const description = this.getAttribute('data-description');
            const image = this.getAttribute('data-image');
            
           
            goToDetailPage(id, name, description, image);
        });
    });
}


if (window.location.pathname === '/veicolo.html') {
    const vehicleId = localStorage.getItem('vehicleId');
    const vehicleName = localStorage.getItem('vehicleName');
    const vehicleDescription = localStorage.getItem('vehicleDescription');
    const vehicleImage = localStorage.getItem('vehicleImage');

    
    if (vehicleId && vehicleName && vehicleDescription && vehicleImage) {
        document.getElementById('vehicle-name').textContent = vehicleName;
        document.getElementById('vehicle-description').textContent = vehicleDescription;
        document.getElementById('vehicle-image').src = vehicleImage;
    } else {
        document.getElementById('vehicle-detail').innerHTML = 'Nessun dato trovato.';
    }
}
