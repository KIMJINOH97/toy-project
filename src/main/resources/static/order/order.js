let userId = localStorage.getItem('user-id');

if (userId === null){
    alert("로그인 후 이용해주세요");
    window.location.href= '/';
}

let $ = (cls) => document.querySelector(`${cls}`)

let orderList = $('.order-list');
let login = $('.login');
let basketButton = document.querySelectorAll('.order-title')[1];

basketButton.addEventListener('click', goBasket);
login.addEventListener('click', goLogin);

function goBasket(e){
    window.location.href = '/basket';
}

function goLogin(e){
    localStorage.removeItem('user-id');
    localStorage.removeItem('user-name');
    window.location.href = '/';
}

async function getOrderList(){
    try {
        const response = await fetch('/api/order-list')
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

        let response = await fetch(`/api/user/${userId}/basket/${orderId}`);
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

getOrderList();

const OrderTemplate = (order) => `
    <li class="order-item">
        <div class="order-content" type="button" onclick="goItem(${order.order_id})">
            <div class="item">${order.order_id}</div>
            <div class="item">
                <img class="order-picture" src="../dummy.png" />
            </div>
            <div class="item">${order.order_name}</div>
            <div class="item">${order.price}</div>
        </div>
        <input type="button" class="pick-button" value="담기" onclick="putBasket(${order.order_id})"/>
    </li>
`;
