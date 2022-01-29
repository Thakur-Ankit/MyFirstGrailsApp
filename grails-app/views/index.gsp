<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to Grails</title>
</head>
<body>

<div id="content" role="main">
    <section class="row colset-2-its">
        <h1>Welcome to Grails</h1>

        <p>
            Congratulations, you have successfully started your first Grails application! At the moment
            this is the default page, feel free to modify it to either redirect to a controller or display
            whatever content you may choose. Below is a list of controllers that are currently deployed in
            this application, click on each to execute its default action:
        </p>

        <div id="controllers" role="navigation">
            <h2>Available Controllers:</h2>
            <ul>
                <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
                    <li class="controller">
                        <g:link controller="${c.logicalPropertyName}">${c.fullName}</g:link>
                    </li>
                </g:each>
            </ul>
        </div>

        <div style="margin-left: 100px;">
            <h3>Rest APIs</h3>
            <h3>...</h3>
            <p>Get List of Person: <a href="http://localhost:8080/person/list">/person/list</a></p>
            <p>Get List of Person with limit(max) : <a href="http://localhost:8080/person/list?max=3">/person/list?max=3</a></p>
            <p>Save a Random Person: <a href="http://localhost:8080/person/save">/person/save</a></p>
            <p>Get List of Person Index Page: <a href="http://localhost:8080/person/index">/person/index</a></p>

        </div>
    </section>
</div>

</body>
</html>
