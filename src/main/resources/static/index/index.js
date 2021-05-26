let submitForm = document.querySelector('.submit-form');
let inputName = document.querySelector('.name-input');

submitForm.addEventListener('submit', login);

let orderItems;

async function login (e){
    e.preventDefault();
    try {
        // console.log(e);
        let requestBody = {name: inputName.value}
        let response = await fetch('/api/user', {
            method: 'POST', body: JSON.stringify(requestBody),
            headers: {'content-type': 'application/json'}
        })
        inputName.textContent = '';
        let {message, data} = await response.json();
        localStorage.setItem("user-id", data.id);
        localStorage.setItem("user-name", data.name);

        window.location.href = '/order-list';
    }catch (e) {
        console.error(e);
    }
};
