let user_api_url = "http://localhost:8080/api/v1/user/products"
let admin_api_url = "http://localhost:8080/api/v1/admin/products"

const listProduct = async function(){
    let result = await fetch(user_api_url);
    let data = await result.json();
    let html = ""
    for(let i = 0; i<data.length;i++){
        let p = data[i];        
        html +=`<tr>
            <td>${p.proId}</td>
            <td>${p.proName}</td>
            <td>${p.producer}</td>
            <td>${p.yearMaking}</td>
            <td>${p.price}</td>
            <td>
                <button id="update" onclick="updateProduct(${p.proId})">Update</button>
                <button id="delete" onclick="deleteProduct(${p.proId})">Delete</button>
            </td>
        </tr>`
    }
    console.log(html);
    document.getElementById("product-data").innerHTML=html;
}

listProduct();

const button = document.getElementById("btnInsert");
button.addEventListener("click",async function(e){
    e.preventDefault();
    //lay du lieu tu form xuong
    let proId = document.getElementById("proId").value;
    let proName = document.getElementById("proName").value;
    let producer = document.getElementById("producer").value;
    let yearMaking = document.getElementById("yearMaking").value;
    let price = document.getElementById("price").value;

    //check xem button do la Insert hay Update
    let name_button = document.getElementById("btnInsert").innerText;
    if(name_button==="Insert"){
        let data = JSON.stringify({"proName":proName,"producer":producer,"yearMaking":yearMaking,"price":price})
        await fetch(admin_api_url,{method:"post",headers:{"Content-Type":"application/json"},body:data}).then(res=>listProduct())
    }else{
        let data = JSON.stringify({"proId":proId,"proName":proName,"producer":producer,"yearMaking":yearMaking,"price":price})
        await fetch(admin_api_url,{method:"put",headers:{"Content-Type":"application/json"},body:data}).then(res=>listProduct())
        document.getElementById("btnInsert").innerText="Insert";
    }    
});


async function deleteProduct(proId){   
    await fetch(admin_api_url+"/"+proId,{method:"delete"}).then(res=>listProduct());
}

async function updateProduct(proId){
    let result = await fetch(user_api_url+"/"+proId);
    let p = await result.json();
    document.getElementById("proId").value = p.proId;
    document.getElementById("proName").value = p.proName;
    document.getElementById("producer").value = p.producer;
    document.getElementById("yearMaking").value = p.yearMaking;
    document.getElementById("price").value = p.price;
    document.getElementById("btnInsert").innerText="Update";
}