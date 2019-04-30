let url = "http://localhost:8080";

export function logout() {
    const requestOptions = {
        method: 'GET',
        // headers: {"Authorization":"Basic "}
    };

    console.log("Logout fetch",requestOptions);
    return fetch(url + '/logout', requestOptions)
        .then(response => {
            if (response.ok) {
                return response.json();
            } else {
                throw new Error('logout not success ...');
            }
        });
}
// export function getUser() {
//     const requestOptions = {
//         method: 'GET',
//         headers: {"Authorization":"Basic c2xhdmFAc3MucnU6MTIz"}
//     };

//     console.log("Activities fetch",requestOptions);
//     return fetch(url + '/api/getUser', requestOptions)
//         .then(response => {
//             if (response.ok) {
//                 return response.json();
//             } else {
//                 throw new Error('User not load ...');
//             }
//         });
// }