let $ = (cls) => document.querySelector(cls);
let container = $('.item-container');


async function getItem() {
    try {
        let itemNumber = localStorage.getItem('item-number');
        console.log(itemNumber);
        let response = await fetch(`/api/order-list/${itemNumber}`);
        let { data:item } = await response.json();
        createItem(item);
        console.log(item);
    }catch (e){
        console.error(e);
    }
}

function createItem(item){
    container.innerHTML += itemTemplate(item);
}


const itemTemplate = (item) => `
    <div class="item-box">
        <div class="item-picture">사진</div>
        <div class="item-content">${item.order_name}</div>
    </div>
`

getItem();