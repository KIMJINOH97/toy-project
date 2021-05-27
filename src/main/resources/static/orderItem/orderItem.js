let $ = (cls) => document.querySelector(cls);
let container = $('.item-container');
let titles = document.querySelectorAll('.order-title');

let userId = localStorage.getItem('user-id');
if (userId === null){
    alert("로그인 후 이용해주세요");
    window.location.href= '/';
}

titles[1].addEventListener('click', ()=>{
    window.location.href = '/order-list';
})

async function getItem() {
    try {
        let itemNumber = localStorage.getItem('item-number');
        let response = await fetch(`/api/order-list/${itemNumber}`);
        let { data:item } = await response.json();
        console.log(item);
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
        <div class="item-picture"><img class="picture" src=${item.url}/></div>
        <div class="item-content">
            <div class="item-name-box">
                <div class="item-name">
                    상품명
                </div>
                <div>${item.order_name}</div>
            </div>
            <div class="item-name-box">
                <div class="item-name">
                    가격
                </div>
                <div>${item.price}원</div>
            </div>
            <div class="item-name-box">
                <div class="item-name">
                    남은 수량
                </div>
                <div>${item.count}개</div>
            </div>
        </div>
    </div>
`

getItem();