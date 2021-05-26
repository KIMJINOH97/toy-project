const $ = (cls) => document.querySelector(cls);

let basketList = $('.basket-list');
let orderButton = document.querySelectorAll('.order-title')[1];
let userId = localStorage.getItem('user-id');

if (userId === null){
    alert("로그인 후 이용해주세요");
    window.location.href= '/';
}

async function getBasket(){
    const userId = localStorage.getItem("user-id");
    const response = await fetch(`/api/user/${userId}/basket`);
    const { data } = await response.json();
    data.map((d) => {
        createBasket(d);
    });
}

orderButton.addEventListener('click', () =>{
    window.location.href = '/order-list';
})

function createBasket(basket) {
    basketList.innerHTML += BasketTemplate(basket);
}

async function deleteBasket(orderId){
    try {
        let userId = localStorage.getItem("user-id");
        if (!userId){
            return window.location.href = '/';
        }

        let response = await fetch(`/api/user/${userId}/basket/${orderId}`, {method: 'DELETE'});
        let {status_code, message} = await response.json();

        if (status_code == 200) {
            alert(message);
            window.location.href = '/basket';
        } else {
            alert(message);
        }
    }catch (e){
        console.error(e);
    }
}

function goItem(orderId){
    localStorage.setItem("item-number", orderId);
    window.location.href = './order-item';
}

const BasketTemplate = (order) => `
    <li class="order-item">
        <div class="order-content" type="button" onClick="goItem(${order.order_id})">
            <div class="item">${order.order_id}</div>
            <div class="item">
                <img class="order-picture" src="dummy.png"/>
            </div>
            <div class="item">${order.order_name}</div>
            <div class="item">${order.price}</div>
        </div>
        <input type="button" class="pick-button" value="삭제" onclick="deleteBasket(${order.order_id})"/>
    </li>
`;

getBasket();
