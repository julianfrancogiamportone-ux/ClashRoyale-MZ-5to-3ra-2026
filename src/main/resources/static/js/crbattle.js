// Variables Globales 
// api de base de datos, gestionado en el controller 
const API_CLASHROYALE = 'http://localhost:8080/api/peleadores'; 
const API_SUPERHEROES = 'http://localhost:8081/api/characters'; // La ruta de Facu

// elementos del html 
const fighter1Select = document.getElementById('fighter1'); 
const fighter2Select = document.getElementById('fighter2'); 
const fighter1Image = document.getElementById('fighter1Image'); 
const fighter2Image = document.getElementById('fighter2Image'); 
const fightButton = document.getElementById('fightButton'); 
const resultDiv = document.getElementById('result'); 

// guardamos los datos obtenidos 
let personajesClash = []; 
let personajesSuperheroes = [];

// Emotes que se muestran en la pantalla de victoria/derrota 
const EMOTE_WIN = 'images/emote_g_2.gif';   // caballero brindando con té: el ganador 
const EMOTE_LOSE = 'images/emote_p.gif';  // cerdito golpeado: el perdedor 
const EMOTE_DRAW = 'images/emote_g_1.gif';    // cerdito sorprendido: empate 

// Traer a los luchadores de AMBOS mundos
async function fetchData() { 
    // Traemos tus personajes (Clash Royale)
    try { 
        const responseClash = await fetch(API_CLASHROYALE); 
        personajesClash = await responseClash.json();   
    } catch (error) { 
        console.error('Error al cargar personajes de Clash Royale:', error); 
    } 

    // Traemos los personajes de Facu (Superhéroes)
    try { 
        const responseHero = await fetch(API_SUPERHEROES); 
        personajesSuperheroes = await responseHero.json();   
    } catch (error) { 
        console.error('Error al cargar personajes de Superhéroes:', error); 
    } 

    // Llamamos a loadFighters() cuando ambos llegaron con éxito
    loadFighters();
} 

// Llenar las listas combinando ambos mundos
function loadFighters() { 
    // Unimos los dos arreglos en uno solo
    const todosLosPersonajes = [...personajesClash, ...personajesSuperheroes];

    todosLosPersonajes.forEach(fighter => { 
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
    if(todosLosPersonajes.length > 0) {
        const selected = JSON.parse(fighter1Select.value); 
        // Agregamos la alternativa .url por si la BD de Facu lo tiene así
        fighter1Image.src = selected.url_imagen || selected.url || 'placeholder.jpg'; 
        
        const selected2  = JSON.parse(fighter2Select.value); 
        fighter2Image.src = selected2.url_imagen || selected2.url || 'placeholder.jpg'; 
    }
} 

// Reaccionar a los cambios 
fighter1Select.addEventListener('change', () => { 
    const selected = JSON.parse(fighter1Select.value); 
    fighter1Image.src = selected.url_imagen || selected.url || 'placeholder.jpg'; 
}); 

fighter2Select.addEventListener('change', () => { 
    const selected = JSON.parse(fighter2Select.value); 
    fighter2Image.src = selected.url_imagen || selected.url || 'placeholder.jpg'; 
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

// Ejecutamos la función para que todo el proceso comience
fetchData();