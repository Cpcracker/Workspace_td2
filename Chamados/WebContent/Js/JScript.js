//Aceita somente numero validando pelo numero decimal na tabela ascii
function Numero(e){
	   var tecla=(window.event)?event.keyCode:e.which;   
		if((tecla>47 && tecla<58)) return true;
		else{
			if (tecla==8 || tecla==0) return true;
		else  return false;
		}
	}
	
//Aceita somete letras validando pelo o codigo decimal na tabela ascii
function Letras(e){
		 var tecla=(window.event)?event.keyCode:e.which;
		 if((tecla >  64 && tecla  <  89)||(tecla > 96 && tecla < 123 ) || (tecla > 31 && tecla <33) ) return true;
		else
		{
		if (tecla != 8) return false; // 8 decimal na tabela ascii e o backspace
		
		else return true;
		}
	}
	
//Mascara da data
 function mascdata(data){ 
    var date = ''; 
    date = date + data; 
        if (date.length == 2){ 
            date = date + '/'; 
            document.forms[0].data.value = date; 
        } 
        if (date.length == 5){ 
            date = date + '/'; 
            document.forms[0].data.value = date; 
        } 
        if (date.length == 10){ 
            verdata(); 
        } 
} 
		  
//Verifica se a data realmente existe.
function verdata () {
    dia = (document.forms[0].data.value.substring(0,2)); 
    mes = (document.forms[0].data.value.substring(3,5)); 
    ano = (document.forms[0].data.value.substring(6,10)); 

    situacao = ""; 
    // verifica o dia valido para cada mes 
    if ((dia < 01)||(dia < 01 || dia > 30) && (  mes == 04 || mes == 06 || mes == 09 || mes == 11 ) || dia > 31) { 
        situacao = "falsa"; 
    } 

    // verifica o mes 
    if (mes < 01 || mes > 12 ) { 
        situacao = "falsa"; 
    } 

    // verifica se e ano bisexto 
    if (mes == 2 && ( dia < 01 || dia > 29 || ( dia > 28 && (parseInt(ano / 4) != ano / 4)))) { 
        situacao = "falsa"; 
    }     
    if (document.forms[0].data.value == "") { 
        situacao = "falsa"; 
    }     
    if (situacao == "falsa") { 
        alert("Data inválida!");
        document.getElementById('data').value=""; 		
        document.forms[0].data.focus(); 
    } 
} 
	
//inicia a validação do formulario
function validacao() {
	
    //verifica se a matricula esta vazia
	var matricula = document.formu.matricula.value;
	    if(matricula=="" || matricula == null){
		 alert("Matricula invalida, informe o numero da Matricula");		
		 document.formu.matricula.focus();
		return false;
	}	
	
	//verifica se o nome está vazio, e o seu tamanho.
	var nome = document.formu.nome.value;
	    if(nome == "" || nome == null ) {
	     alert("Nome invalido, Informe o seu nome.");
		 document.getElementById('nome').value="";
	     document.formu.nome.focus();	 
	    return false;
	    }else
	    if(nome.length < 3){
	     alert("Nome invalido, Digite seu nome completo.");
		 document.getElementById('nome').value="";
	     document.formu.nome.focus(); 
	    return false;
	}	
	
	//Verifica se o campo sexo está selecionado
	if(!document.formu.sexo[0].checked && !document.formu.sexo[1].checked){
		 alert("Selecione o sexo.");
		return false;
	}		
		
	//Verifica se a data está vazia
	var dt =document.formu.data.value;
		if(dt == ""){
		 alert("Data invalida, insira a data");
		 document.formu.data.focus();
		return false;
	}	
	
	//Verifica se o curso está selecionado	
	var selecione= document.formu.curso.value;
		if( selecione == "selecioneocurso"){
		 alert("Selecione um curso");
		return false;
	}	
	
	//Verifica se o e-mail é valido	
	var email = document.formu.email.value;
	    if(email.indexOf("@") == -1 ||
	     email.indexOf(".") == -1 || email == "" || email == null) {
	     alert("E-mail invalido, informe um e-mail valido.");
		 document.getElementById('email').value="";
	     document.formu.email.focus();
	    return false;
	}	
	
	//Verifica o capo senha e confirma senha
	var senha = document.formu.senha.value;
	var senha2 = document.formu.senha2.value;	 
	 if(senha == "" || senha== null){
		 alert ("Senha invalida, insira a senha novamente");
		 document.getElementById('senha').value="";		 
		 document.getElementById('senha2').value="";
		 document.formu.senha.focus();
		return false;
	 } else
	 if(senha != senha2){
		 alert("Divergencia de senha, Digite novamente");
         document.getElementById('senha').value="";		 
		 document.getElementById('senha2').value="";
		 document.formu.senha2.focus();		 
	 return false;
	}
	
	//Verifica se o a pessoa descreveu o motivo do curso.
    if(formu.motivcurso.value == "" || formu.motivcurso.value == null) {
     alert("Por favor, conte-nos qual a motivacao para realizar o curso.");
     formu.motivcurso.focus();
    return false;
    }

    //Com tudo preenchido corretamente será permitido o envio do formulário.
    alert('Voce preencheu o formulario corretamente. obrigado !.');
    return true;
}	