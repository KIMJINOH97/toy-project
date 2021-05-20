let submitForm = document.querySelector('.submit-form');
let inputName = document.querySelector('.name-input');

let URL = 'http://localhost:8080'

submitForm.addEventListener('submit', login);

let orderItems;

async function login (e){
    e.preventDefault();
    try {
        // console.log(e);
        let requestBody = {name: inputName.value}
        let response = await fetch(`${URL}/api/user`, {
            method: 'POST', body: JSON.stringify(requestBody),
            headers: {'content-type': 'application/json'}
        })
        inputName.textContent = '';
        let {message, data} = await response.json();
        localStorage.setItem("user-id", data.id);
        localStorage.setItem("user-name", data.name);
        console.log(message, data);

        response = await fetch(`${URL}/api/order-list`);
        let {status_code, data: orderItems} = await response.json();

        if (status_code == 200){
            console.log(orderItems);
            window.location.href = `${URL}/order-list`;
        }
        else
            alert("주문 목록을 가져오는데 실패했습니다!!.");
    }catch (e) {
        console.error(e);
    }
};
