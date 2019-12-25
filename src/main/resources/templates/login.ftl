<#import "common.ftl" as c>


<@c.page>

    <div class="row mt-3">

        <div class="col-md-3"></div>
        <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3 pt-4 pl-4 pr-4 ">


            <#if Session?? && Session.SPRING_SECURITY_LAST_EXCEPTION??>
                <div class="alert alert-danger" role="alert">
                    ${Session.SPRING_SECURITY_LAST_EXCEPTION.message}
                </div>
            </#if>
            <#if message??>
                <div class="alert alert-${messageType}" role="alert">
                    ${message}
                </div>
            </#if>

            <#-- <h2>Social networks</h2>
             <hr class="colorgraph">

             <div>
                 <#include "fragments/social.ftl">
             </div>-->


            <form class="form-signin" method="post" action="/login">
                <h2 class="form-signin-heading">Логин</h2>


                <b>login - admin, password - 1</b>

                <label for="inputEmail" class="sr-only">Username</label>
                <input type="text"
                        <#--                   pattern="[a-zA-Z0-9]+"-->
                        <#--                   title="Username must be Alphanumeric (only letters and digits)!" -->
                       id="inputEmail"
                       class="form-control ${(usernameError??)?string('is-invalid', '')}" placeholder="Username"
                       required autofocus name="username">
                <#if usernameError??>
                    <div class="invalid-feedback">
                        ${usernameError}
                    </div>
                </#if>
                <label for="inputPassword" class="sr-only">Password</label>
                <input type="password" id="inputPassword"
                       class="form-control ${(passwordError??)?string('is-invalid', '')}" placeholder="Password"
                       required name="password">
                <#if passwordError??>
                    <div class="invalid-feedback">
                        ${passwordError}
                    </div>
                </#if>

                <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
            </form>


            <div class="col-md-3"></div>
        </div>
    </div>
</@c.page>