<#assign
known = Session.SPRING_SECURITY_CONTEXT??
>

<#if known>
    <#assign
    user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
    name = user.getUsername()
    currentUserId = user.getId()
    ><script>
    var username = "${name}";
    var user_id = "${user.getId()}";
</script>
<#else>
    <#assign
    name = "unknown"
    currentUserId = -1
    >
</#if>


<nav class="navbar navbar-expand-lg navbar-light bg-white border-bottom shadow-sm" id="navbar">
        <div class="container">
            <a class="navbar-brand" href="/">
            </a>

            <button class="navbar-toggler" type="button" data-toggle="collapse"
                    data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="/"><span class="sr-only">(current)</span></a>
                    </li>

                </ul>
                <ul class="navbar navbar-nav navbar-right">
                    <li class="nav-item"><a class="nav-link" href="/">Main</a></li>

                    <!-- Authentication Links -->
                    <#if currentUserId?? && currentUserId == -1>

                        <li class="nav-item"><a class="nav-link" href="/login">Login</a></li>

                    <#elseif name??>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span>${name}</span>
                            </a>

                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <form action="/logout" method="post">
                                    <button class="dropdown-item"  type="submit">Sign Out</button>
                                </form>
                            </div>
                        </li>
                    </#if>
                </ul>
            </div>
        </div>
    </nav>


