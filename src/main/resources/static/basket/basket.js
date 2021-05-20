let basketList = document.querySelector('.basket-list');
let orderButton = document.querySelector('.go-orderList');

async function getBasket(){
    console.log("hi");
    const userId = localStorage.getItem("user-id");
    const response = await fetch(`/api/user/${userId}/basket`);
    const { data } = await response.json();
    data.map((d) => {
        console.log(d, d.name);
        createItem(basketList, d);
    });
}

orderButton.addEventListener('click', () =>{
    window.location.href = '/order-list';
})

getBasket();


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
    itemPicture.src = '../dummy.png';
    itemName.className = 'item';
    itemPrice.className = 'item';
    itemNumber.textContent = data.order_id;
    itemName.textContent = data.order_name;
    itemPrice.textContent = data.price;
    itemPictureDiv.appendChild(itemPicture);
    orderItem.appendChild(itemNumber);
    orderItem.appendChild(itemPictureDiv);
    orderItem.appendChild(itemName);
    orderItem.appendChild(itemPrice);
    parent.append(orderItem);
}