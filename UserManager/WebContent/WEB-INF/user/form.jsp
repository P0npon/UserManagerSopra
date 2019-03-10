<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link type="text/css" rel="stylesheet" href="styleRegister.css" />
</head>
<body>
<form method="post" action="registerServlet">
	    <fieldset>
                <legend>Inscription</legend>
                <p>Vous pouvez vous inscrire via ce formulaire.</p>

                <label for="email">Adresse email <span class="requis">*</span></label>
                <input type="email" id="email" name="email" value="${form['email']}" size="20" maxlength="60" />
                <span class="erreur">${erreurs['email']}</span>
                <br />

                <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
                <input type="password" id="motdepasse" name="motdepasse" value="${form['motdepasse']}" size="20" maxlength="20" />
                <span class="erreur">${erreurs['motdepasse']}</span>
                <br />

                <label for="confirmation">Confirmation du mot de passe <span class="requis">*</span></label>
                <input type="password" id="confirmation" name="confirmation" value="${form['confirmation']}" size="20" maxlength="20" />
                <span class="erreur">${erreurs['confirmation']}</span>
                <br />

                <label for="nom">Nom d'utilisateur</label>
                <input type="text" id="nom" name="nom" value="${form['nom']}" size="20" maxlength="20" />
                <span class="erreur">${erreurs['nom']}</span>
                <br />

                <input type="submit" value="Inscription" class="sansLabel" />
                <br />
                
                <p class="${empty erreurs ? 'succes' : 'erreur'}">${resultat}</p>
            </fieldset>
            
          </form>

</body>
</html>