let URL = 'http://localhost:8080'

let orderContainer = document.querySelector('.order-container');
let basketButton = document.querySelector('.basket-button');

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
            createItem(orderContainer, d);
        });
        console.log(data);
    }catch (e) {
         console.log(e.message);
    }
}

function createItem(parent, data) {
    let orderItem = document.createElement('li');
    let itemNumber = document.createElement('div');
    let itemPictureDiv = document.createElement('div');
    let itemPicture = document.createElement('img');
    let itemName = document.createElement('div');
    let itemPrice = document.createElement('div');
    orderItem.className = 'order-item';
    itemNumber.className = 'item';
    itemPictureDiv.className = 'picture-div';
    itemPicture.className = 'order-picture';
    itemPicture.src = './dummy.png';
    itemName.className = 'item';
    itemPrice.className = 'item';
    itemNumber.textContent = data.id;
    itemName.textContent = data.name;
    itemPrice.textContent = data.price;
    itemPictureDiv.appendChild(itemPicture);
    orderItem.appendChild(itemNumber);
    orderItem.appendChild(itemPictureDiv);
    orderItem.appendChild(itemName);
    orderItem.appendChild(itemPrice);
    parent.append(orderItem);
}

getOrderList();