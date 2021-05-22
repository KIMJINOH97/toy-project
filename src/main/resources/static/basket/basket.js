const $ = (cls) => document.querySelector(cls);

let basketList = $('.basket-list');
let orderButton = document.querySelectorAll('.order-title')[1];

async function getBasket(){
    console.log("hi");
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
        console.log(status_code, message);
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

const BasketTemplate = (order) => `
    <li class="order-item">
        <div class="item">${order.order_id}</div>
        <div class="item">
            <img class="order-picture" src="dummy.png" />
        </div>
        <div class="item">${order.order_name}</div>
        <div class="item">${order.price}</div>
        <div class="item">
            <input type="button" class="pick-button" value="삭제" onclick="deleteBasket(${order.order_id})"/>
        </div>
    </li>
`;


getBasket();
