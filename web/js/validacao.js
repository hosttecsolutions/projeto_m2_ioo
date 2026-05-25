/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function validarFormulario() {
    var nome = document.f1.txtnome.value;
    var cpf = document.f1.txtcpf.value;
    var email = document.f1.txtemail.value;

    if (nome === "" || cpf === "" || email === "") {
        alert("Preencha pelo menos os campos Nome, CPF e Email.");
        return false;
    }

    return true;
}
