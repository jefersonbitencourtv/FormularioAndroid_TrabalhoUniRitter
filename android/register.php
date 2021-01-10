<?php
if ($_SERVER['REQUEST_METHOD']=='POST'){

    require_once 'connect.php';

    $nome = $_POST['nome'];
    $email = $_POST['email'];
    $datanascimento = $_POST['datanascimento'];
    $identidade = intval($_POST['identidade']);
    $celular = intval($_POST['celular']);
    $telefone = intval($_POST['telefone']);
    $endereco = $_POST['endereco'];
    $numero = intval($_POST['numero']);
    $complemento = $_POST['complemento'];
    $bairro = $_POST['bairro'];
    $estado = $_POST['estado'];
    $cidade = $_POST['cidade'];
    $nome_escola = $_POST['nome_escola'];
    $bairro_escola = $_POST['bairro_escola'];
    $ano = $_POST['ano'];
    $turma = $_POST['turma'];
    $perfil_escola = $_POST['perfil_escola'];
    $realistico = floatval($_POST['realistico']);
    $investigativo = floatval($_POST['investigativo']);
    $empreendedor = floatval($_POST['empreendedor']);
    $convencional = floatval($_POST['convencional']);
    $artistico = floatval($_POST['artistico']);
    $social = floatval($_POST['social']);


    $sql = "INSERT INTO aluno(nome,email,datanascimento,identidade,celular,telefone,endereco,numero,complemento,bairro,estado,cidade,nome_escola,bairro_escola,ano,turma,perfil_escola,realistico,investigativo,empreendedor,convencional,artistico,social)VALUES ('$nome','$email','$datanascimento','$identidade','$celular','$telefone','$endereco','$numero','$complemento','$bairro','$estado','$cidade','$nome_escola','$bairro_escola','$ano','$turma','$perfil_escola','$realistico','$investigativo','$empreendedor','$convencional','$artistico','$social')";
    
    if (mysqli_query($conn, $sql)){
        $result["sucess"]="1";
        $result["message"]="sucesso";
    }
    else{
        $result["sucess"]="0";
        $result["message"]="error";
    }

    echo json_encode($result);
    mysqli_close($conn);


}