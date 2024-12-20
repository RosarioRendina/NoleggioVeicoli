var swiper = new Swiper(".mySwiper", {});

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
    veicoli.push(data);
    
})
.catch(error => {
    console.error('Errore:', error);
});