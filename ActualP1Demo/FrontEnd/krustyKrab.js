const url = "http://localhost:3000/";
// Your projects will replace localhost with your AWS endpoint

document.getElementById("getEmployeeButton").addEventListener("click",getEmployees);
document.getElementById("loginButton").addEventListener("click",loginFunction);


async function getEmployees(){
    let response = await fetch(url + "employee", {credentials: "include"});

    console.log(response);

    if(response.status === 200){
        let data = await response.json(); //Our response is NOT JSON... Its something else. So .json() Parses our response into a JSON object

        console.log(data);

        //For every Employee object we get, put it in the table please!
        for(let employee of data){
            //This specifically creates a variable that is a row
            let row = document.createElement("tr");
            //creates a data cell for each employee field
            let cell = document.createElement("td");
            //fill the cell with our employee data
            cell.innerHTML = employee.employee_id;
            //add the td element (our data cell) to the tr element (our tables row)
            row.appendChild(cell); // This specifically adds this cell to the above roll


            //creates a data cell for each employee field
            let cell2 = document.createElement("td");
            //fill the cell with our employee data
            cell2.innerHTML = employee.f_name;
            //add the td element (our data cell) to the tr element (our tables row)
            row.appendChild(cell2);


            //creates a data cell for each employee field
            let cell3 = document.createElement("td");
            //fill the cell with our employee data
            cell3.innerHTML = employee.l_name;
            //add the td element (our data cell) to the tr element (our tables row)
            row.appendChild(cell3);


            //creates a data cell for each employee field
            let cell4 = document.createElement("td");
            //fill the cell with our employee data
            cell4.innerHTML = employee.role_id;
            //add the td element (our data cell) to the tr element (our tables row)
            row.appendChild(cell4);

            //We want to loop this, so we need to attach this row
            document.getElementById("employeeBody").appendChild(row); //This right here, actually add our row to our HTML
        }
    }
}

async function loginFunction(){
    let usern = document.getElementById("username").value;
    let userp = document.getElementById("password").value;
    console.log(usern);
    console.log(userp);
    //This is us making our user JSON object, so that we can send it to our database
    let user = {
        username: usern,
        password: userp
    }

    console.log(user);

    let response = await fetch(url + "login",{
        method: "POST", //This is what we are doing, we are created an employee, so it is a post request
        body: JSON.stringify(user), //This will turn our user object into JSON we can send
        credentials: "include"
    });

    console.log(response.status);

    if(response.status === 201){
        document.getElementById("loginRow").innerText = "Welcome to the Manager Menu!";
    }
    else if(response.status === 202){
        document.getElementById("loginRow").innerText = "Welcome to the Employee Menu!";
    }
    else{
        document.getElementById("loginRow").innerText = "Login Failed, please refresh the page!";
    }

}