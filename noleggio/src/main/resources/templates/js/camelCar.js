var swiper = new Swiper(".mySwiper", {
    navigation: {
      nextEl: ".swiper-button-next",
      prevEl: ".swiper-button-prev",
    },
  });
const swiperbutton = document.querySelector('.swiper').swiper;

// Now you can use all slider methods like
swiperbutton.slideNext();

const key = 'http://localhost:8080/api/veicolo';

const veicoli = [];


fetch(key)
.then(response => {
    if (!response.ok) {
        throw new Error('Errore nella richiesta');
    }
    return response.json();
})
.then(data => {
    console.log(data); 
    aggiungiVeicoli(data);
    
})
.catch(error => {
    console.error('Errore:', error);
});

function aggiungiVeicoli(veicoli) {
    let container = document.querySelector('.swiper-wrapper');

    veicoli.forEach(veicolo => {
        const imageUrl = getImageUrl(veicolo.categoria);
        container.innerHTML+= `
            <div class="swiper-slide">
                <div class="card" style="max-width: 18rem;">
                    <img src="${imageUrl}" class="card-img-top" alt="${veicolo.categoria}">
                    <div class="card-body">
                        <h5 class="card-title">${veicolo.categoria}</h5>
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item">Marca: ${veicolo.marca}</li>
                            <li class="list-group-item">Modello: ${veicolo.modello}</li>
                            <li class="list-group-item">Indirizzo: ${veicolo.indirizzo}</li>
                            <li class="list-group-item">Disponibilità: ${veicolo.disponibilita?"Noleggiabile":"Prenotata"}</li>
                        </ul>
                        <div class="card-body text-center d-flex">
                        <a href="/templates/utente.html" class="card-link btn btn-primary" style="margin-right: 0.5rem;">Prenota</a>
                        <a href="/templates/veicolo.html?id=${veicolo.veicolo_id}" class="card-link btn btn-secondary" )>Informazioni</a>
                    </div>
                    </div>
                </div>
            </div>
        `;
    });
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

//gestione info veicolo 



// login

const uriUtente = 'http://localhost:8080/api/utente/curr';



fetch (uriUtente) 
    .then(response => {
        console.log(response);
        return response.json();
        
    })

    .then (data => {
        console.log(data);
        
    })

    .catch(err => {
        console.log(err);
        
    });