
// function goToDetailPage(id, name, description, image) {
    
//     localStorage.setItem('vehicleId', id);
//     localStorage.setItem('vehicleName', name);
//     localStorage.setItem('vehicleDescription', description);
//     localStorage.setItem('vehicleImage', image);

    
//     window.location.href = 'veicolo.html'; 
// }

// // Controlliamo se siamo nella pagina principale (index.html)
// if (window.location.pathname === '/index.html') {
//     const images = document.querySelectorAll('.carousel img');
    
//     images.forEach(img => {
//         img.addEventListener('click', function() {
//             const id = this.getAttribute('data-id');
//             const name = this.getAttribute('data-name');
//             const description = this.getAttribute('data-description');
//             const image = this.getAttribute('data-image');
            
           
//             goToDetailPage(id, name, description, image);
//         });
//     });
// }


// if (window.location.pathname === '/veicolo.html') {
//     const vehicleId = localStorage.getItem('vehicleId');
//     const vehicleName = localStorage.getItem('vehicleName');
//     const vehicleDescription = localStorage.getItem('vehicleDescription');
//     const vehicleImage = localStorage.getItem('vehicleImage');

    
//     if (vehicleId && vehicleName && vehicleDescription && vehicleImage) {
//         document.getElementById('vehicle-name').textContent = vehicleName;
//         document.getElementById('vehicle-description').textContent = vehicleDescription;
//         document.getElementById('vehicle-image').src = vehicleImage;
//     } else {
//         document.getElementById('vehicle-detail').innerHTML = 'Nessun dato trovato.';
//     }
// }



function getQueryParam(param) {
    const urlParams = new URLSearchParams(window.location.search);
    return urlParams.get(param);
    
}


const veicoloId = getQueryParam("id");
console.log("ID veicolo:", veicoloId);

console.log("URL completo:", window.location.href);


const key = 'http://localhost:8080/api/veicolo';

fetch(key)
    .then(response => {
        if (!response.ok) {
            throw new Error('Errore nella richiesta');
        }
        return response.json();
    })
    .then(veicoli => {
        
        const veicolo = veicoli.find(v => v.veicolo_id === parseInt(veicoloId));

        if (veicolo) {
            mostraDettagliVeicolo(veicolo);
        } else {
            console.error("Veicolo non trovato");
            document.querySelector(".veicolo-card").innerHTML = "Veicolo non trovato.";
        }
    })
    .catch(error => {
        console.error('Errore:', error);
    });

    function mostraDettagliVeicolo(veicolo) {
        const imageUrl = getImageUrl(veicolo.categoria);
        const veicoloCard = document.querySelector('.veicolo-card');
    
        veicoloCard.innerHTML = `
      <div class="card" style="max-width: 18rem;">
        <img src="${imageUrl}" class="card-img-top" alt="${veicolo.categoria}">
        <div class="card-body">
            <h5 class="card-title">${veicolo.categoria}</h5>
            <ul class="list-group list-group-flush">
              <li class="list-group-item">Disponibilità: ${veicolo.disponibilita}</li>
                <li class="list-group-item">Marca: ${veicolo.marca}</li>
                <li class="list-group-item">Modello: ${veicolo.modello}, Colore: ${veicolo.colore}</li>
                <li class="list-group-item">Colore: ${veicolo.colore}</li>
                <li class="list-group-item">Alimentazione: ${veicolo.alimentazione}</li>
                <li class="list-group-item">Cilindrata: ${veicolo.cilindrata}</li>
                <li class="list-group-item">Indirizzo: ${veicolo.indirizzo}</li>
                <li class="list-group-item">Coordinate: ${veicolo.coordinate}</li>
            </ul>
            <div class="card-body text-center d-flex">
            <a href="/templates/utente.html" class="d-flex btn btn-primary align-items-center" style="margin-right: 0.5rem;">Prenota</a>
            <a href="/templates/index.html" class="card-link btn btn-secondary">Torna alla home</a>
        </div>
        </div>
      </div>
        `;
    }

let monopattinoUrl = 'images/monopattino.jpg';
let cammelloUrl = 'images/cammello.png';
let biciUrl = 'images/bicicletta.jpg';
let furgoneUrl = 'images/furgone.jpg';
let macchinaUrl = 'images/macchina.jpg';
let scooterUrl = 'images/motorino.png';
let motoUrl = 'images/moto.jpg';

function getImageUrl(categoria) {
    if (categoria === 'AUTO') {
        return macchinaUrl;
    } else if (categoria === 'SCOOTER') {
        return scooterUrl;
    } else if (categoria === 'MOTO') {
        return motoUrl;
    } else if (categoria === 'FURGONE') {
        return furgoneUrl;
    } else if (categoria === 'MONOPATTINO') {
        return monopattinoUrl;
    } else if (categoria === 'CAMMELLO') {
        return cammelloUrl;
    } else if (categoria === 'MACCHINA') {
        return macchinaUrl;
    } else if (categoria === 'BICICLETTA') {
        return biciUrl;
    } else {
        return 'images/default.jpg';
    }
}

