let URL = 'http://localhost:8080'

let $ = (cls) => document.querySelector(`${cls}`)

let orderList = $('.order-list');
let basketButton = document.querySelectorAll('.order-title')[1];
basketButton.addEventListener('click', goBasket);

function goBasket(e){
    window.location.href = `${URL}/basket`;
}

async function getOrderList(){
    try {
        const response = await fetch(`${URL}/api/order-list`)
        if (!response.ok){
            throw new Error("에러메세지");
        }
        const { data } = await response.json();
        data.map((d) => {
            createItem(d);
        });
        console.log(data);
    }catch (e) {
         console.log(e.message);
    }
}

function createItem(data) {
    orderList.innerHTML += OrderTemplate(data);
}

async function putBasket(orderId){
    try {
        let userId = localStorage.getItem("user-id");

        if (!userId){
            return window.location.href = '/';
        }

        let response = await fetch(`${URL}/api/user/${userId}/basket/${orderId}`);
        console.log(`${URL}/api/user/${userId}/basket/${orderId}`)
        console.log(response);
        let {message, status_code} = await response.json();
        if (status_code == 200) {
            alert(message);
        } else if (status_code == 400) {
            alert(message);
        }
        console.log(message, status_code);
    }catch (e){
        console.error(e);
    }
}

function goItem(orderId){
    localStorage.setItem("item-number", orderId);
    window.location.href = './order-item';
}

const OrderTemplate = (order) => `
    <li class="order-item">
        <div class="item">${order.order_id}</div>
        <div class="item">
            <img class="order-picture" src="dummy.png" />
        </div>
        <div  type="button" onclick="goItem(${order.order_id})" class="item">${order.order_name}</div>
        <div class="item">${order.price}</div>
        <div class="item">
            <input type="button" class="pick-button" value="담기" onclick="putBasket(${order.order_id})"/>
        </div>
    </li>
`;

getOrderList();
