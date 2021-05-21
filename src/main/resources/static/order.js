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

const OrderTemplate = (order) => `
    <li class="order-item">
        <div class="item">${order.order_id}</div>
        <div class="item">
            <img class="order-picture" src="dummy.png" />
        </div>
        <div class="item">${order.order_name}</div>
        <div class="item">${order.price}</div>
        <div class="item"><input type="button" class="pick-button" value="담기"/></div>
    </li>
`;

getOrderList();
