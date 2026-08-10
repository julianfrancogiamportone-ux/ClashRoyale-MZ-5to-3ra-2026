// Variables Globales 
// api de base de datos, gestionado en el controller 
const API_DRAGONBALL = 'http://localhost:8080/api/peleadores'; 

// elementos del html 
const fighter1Select = document.getElementById('fighter1'); 
const fighter2Select = document.getElementById('fighter2'); 
const fighter1Image = document.getElementById('fighter1Image'); 
const fighter2Image = document.getElementById('fighter2Image'); 
const fightButton = document.getElementById('fightButton'); 
const resultDiv = document.getElementById('result'); 

// guardamos los datos obtenidos 
let characters = []; 

// Emotes que se muestran en la pantalla de victoria/derrota 
const EMOTE_WIN = 'images/emote_g_2.gif';   // caballero brindando con té: el ganador 
const EMOTE_LOSE = 'images/emote_p.gif';  // cerdito golpeado: el perdedor 
const EMOTE_DRAW = 'images/emote_g_1.gif';    // cerdito sorprendido: empate 

// Traer a los luchadores 
async function fetchData() { 
    try { 
        const responseDB = await fetch(API_DRAGONBALL); 
        characters = await responseDB.json();   
        
        // 1. CORRECCIÓN: Llamamos a loadFighters() cuando los datos llegan con éxito
        loadFighters();
    } catch (error) { 
        console.error('Error al cargar los personajes:', error); 
    } 
} // 2. CORRECCIÓN: Cerramos la función fetchData() acá.

// Llenar las listas 
// por cada peleador creamos un option en el selector 
function loadFighters() { 
    [...characters].forEach(fighter => { 
        const option1 = document.createElement('option'); 
        option1.value = JSON.stringify(fighter); 
        option1.text = `${fighter.nombre} `; 
        fighter1Select.appendChild(option1); 
        
        const option2 = document.createElement('option'); 
        option2.value = JSON.stringify(fighter); 
        option2.text = `${fighter.nombre} `; 
        fighter2Select.appendChild(option2); 
    }); 
    
    // Verificamos que haya personajes antes de intentar mostrar la imagen
    if(characters.length > 0) {
        const selected = JSON.parse(fighter1Select.value); 
        fighter1Image.src = selected.url_imagen || 'placeholder.jpg'; 
        const selected2  = JSON.parse(fighter2Select.value); 
        fighter2Image.src = selected2.url_imagen || 'placeholder.jpg'; 
    }
} 

// Reaccionar a los cambios 
// Actualizar la imagen al seleccionar un personaje 
fighter1Select.addEventListener('change', () => { 
    const selected = JSON.parse(fighter1Select.value); 
    fighter1Image.src = selected.url_imagen || 'placeholder.jpg'; 
}); 

fighter2Select.addEventListener('change', () => { 
    const selected = JSON.parse(fighter2Select.value); 
    fighter2Image.src = selected.url_imagen || 'placeholder.jpg'; 
}); 

// La Lógica de Batalla  
fightButton.addEventListener('click', () => { 
    const fighter1 = JSON.parse(fighter1Select.value); 
    const fighter2 = JSON.parse(fighter2Select.value); 
    
    if (!fighter1 || !fighter2) { 
        alert('Seleccioná ambos luchadores.'); 
        return; 
    } 
    
    // Simular "nivelDePoder" 
    const power1 = fighter1.nivelDePoder || (Math.floor(Math.random() * 1000) + 500); 
    const power2 = fighter2.nivelDePoder || (Math.floor(Math.random() * 1000) + 500); 
    
    let winner; 
    
    if (power1 > power2) { 
        winner = fighter1.nombre; 
        fighter1Image.src = EMOTE_WIN; 
        fighter2Image.src = EMOTE_LOSE; 
    } else if (power2 > power1) { 
        winner = fighter2.nombre; 
        fighter1Image.src = EMOTE_LOSE; 
        fighter2Image.src = EMOTE_WIN; 
    } else { 
        winner = "¡Empate!"; 
        fighter1Image.src = EMOTE_DRAW; 
        fighter2Image.src = EMOTE_DRAW; 
    } 
    
    resultDiv.textContent = `🏆 El ganador es: ${winner}! 🏆`; 
    resultDiv.classList.remove('hidden'); 
}); 

// 3. CORRECCIÓN: Ejecutamos la función para que todo el proceso comience
fetchData();