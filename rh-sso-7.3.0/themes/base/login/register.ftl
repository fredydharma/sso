<#import "template-custom-register.ftl" as layout>
<@layout.registrationLayout; section>
    <#if section = "header">
        ${msg("registerTitle")}
    <#elseif section = "form">
        <p id="ajax-status" class="text-center">Loading: Ceritanya lagi nge-get data Person...</p>
        <form id="kc-register-form" class="${properties.kcFormClass!}" action="${url.registrationAction}" method="post">

            <input type="hidden" id="xregistration_type" name="user.attributes.registration_type" value="MANUAL">
            <input type="hidden" id="xlastname" name="lastName" value="x" />

            <div class="${properties.kcFormGroupClass!} ${messagesPerField.printIfExists('vehicles',properties.kcFormGroupErrorClass!)}">
                <div class="${properties.kcLabelWrapperClass!}">
                    <label id="xvehicles_msg" for="xvehicles" class="${properties.kcLabelClass!}">${msg("vehicles")}</label>
                </div>
                <div class="${properties.kcInputWrapperClass!}">
                    <input
                        type="text"
                        id="xvehicles"
                        class="${properties.kcInputClass!}"
                        name="user.attributes.vehicles"
                        value="ABC1,ABC2" 
                    />
                </div>
            </div>
            <div class="${properties.kcFormGroupClass!} ${messagesPerField.printIfExists('icfin',properties.kcFormGroupErrorClass!)}">
                <div class="${properties.kcLabelWrapperClass!}">
                    <label id="xicfin_msg" for="user.attributes.icfin" class="${properties.kcLabelClass!}">${msg("icfin")}</label>
                </div>
                <div class="${properties.kcInputWrapperClass!}">
                    <input
                        type="text"
                        id="xicfin"
                        class="${properties.kcInputClass!}"
                        name="user.attributes.icfin"
                        value="1234567890" 
                    />
                </div>
            </div>

            <div class="${properties.kcFormGroupClass!} ${messagesPerField.printIfExists('dob',properties.kcFormGroupErrorClass!)}">
                <div class="${properties.kcLabelWrapperClass!}">
                    <label for="xdob" class="${properties.kcLabelClass!}">${msg("dob")}</label>
                </div>
                <div class="${properties.kcInputWrapperClass!}">
                    <input
                        type="text"
                        id="xdob"
                        class="${properties.kcInputClass!}"
                        name="user.attributes.dob"
                        value="05-12-1993" 
                        readonly="readonly"
                    />
                </div>
            </div>

            <div class="${properties.kcFormGroupClass!} ${messagesPerField.printIfExists('address',properties.kcFormGroupErrorClass!)}">
                <div class="${properties.kcLabelWrapperClass!}">
                    <label for="xaddress" class="${properties.kcLabelClass!}">${msg("address")}</label>
                </div>
                <div class="${properties.kcInputWrapperClass!}">
                    <input
                        type="text"
                        id="xaddress"
                        class="${properties.kcInputClass!}"
                        name="user.attributes.address"
                        value="Jl.Address" 
                    />
                </div>
            </div>

            <div class="${properties.kcFormGroupClass!} ${messagesPerField.printIfExists('firstName',properties.kcFormGroupErrorClass!)}">
                <div class="${properties.kcLabelWrapperClass!}">
                    <label for="xfirstname" class="${properties.kcLabelClass!}">${msg("firstName")}</label>
                </div>
                <div class="${properties.kcInputWrapperClass!}">
                    <input type="text" id="xfirstname" class="${properties.kcInputClass!}" name="firstName" value="John Doe" />
                </div>
            </div>

            <!-- End Modify form -->

            <div class="${properties.kcFormGroupClass!} ${messagesPerField.printIfExists('phone',properties.kcFormGroupErrorClass!)}">
                <div class="${properties.kcLabelWrapperClass!}">
                    <label for="user.attributes.phone" class="${properties.kcLabelClass!}">${msg("phone")}</label>
                </div>
                <div class="${properties.kcInputWrapperClass!}">
                    <input
                        type="text"
                        id="user.attributes.phone"
                        class="${properties.kcInputClass!}"
                        name="user.attributes.phone"
                        value="089514512776" 
                    />
                </div>
            </div>
            
            <div class="${properties.kcFormGroupClass!} ${messagesPerField.printIfExists('email',properties.kcFormGroupErrorClass!)}">
                <div class="${properties.kcLabelWrapperClass!}">
                    <label for="email" class="${properties.kcLabelClass!}">${msg("email")}</label>
                </div>
                <div class="${properties.kcInputWrapperClass!}">
                    <input type="text" id="email" class="${properties.kcInputClass!}" name="email" value="${(register.formData.email!'')}" autocomplete="email" />
                </div>
            </div>

          <#if !realm.registrationEmailAsUsername>
            <div class="${properties.kcFormGroupClass!} ${messagesPerField.printIfExists('username',properties.kcFormGroupErrorClass!)}">
                <div class="${properties.kcLabelWrapperClass!}">
                    <label for="username" class="${properties.kcLabelClass!}">${msg("username")}</label>
                </div>
                <div class="${properties.kcInputWrapperClass!}">
                    <input type="text" id="username" class="${properties.kcInputClass!}" name="username" value="${(register.formData.username!'')}" autocomplete="username" />
                </div>
            </div>
          </#if>

            <#if passwordRequired>
            <div class="${properties.kcFormGroupClass!} ${messagesPerField.printIfExists('password',properties.kcFormGroupErrorClass!)}">
                <div class="${properties.kcLabelWrapperClass!}">
                    <label for="password" class="${properties.kcLabelClass!}">${msg("password")}</label>
                </div>
                <div class="${properties.kcInputWrapperClass!}">
                    <input type="password" id="password" class="${properties.kcInputClass!}" name="password" autocomplete="new-password"/>
                </div>
            </div>

            <div class="${properties.kcFormGroupClass!} ${messagesPerField.printIfExists('password-confirm',properties.kcFormGroupErrorClass!)}">
                <div class="${properties.kcLabelWrapperClass!}">
                    <label for="password-confirm" class="${properties.kcLabelClass!}">${msg("passwordConfirm")}</label>
                </div>
                <div class="${properties.kcInputWrapperClass!}">
                    <input type="password" id="password-confirm" class="${properties.kcInputClass!}" name="password-confirm" />
                </div>
            </div>
            </#if>

            <#if recaptchaRequired??>
            <div class="form-group">
                <div class="${properties.kcInputWrapperClass!}">
                    <div class="g-recaptcha" data-size="compact" data-sitekey="${recaptchaSiteKey}"></div>
                </div>
            </div>
            </#if>

            <div class="${properties.kcFormGroupClass!}">
                <div id="kc-form-options" class="${properties.kcFormOptionsClass!}">
                    <div class="${properties.kcFormOptionsWrapperClass!}">
                        <span><a href="${url.loginUrl}">${kcSanitize(msg("backToLogin"))?no_esc}</a></span>
                    </div>
                </div>

                <div id="kc-form-buttons" class="${properties.kcFormButtonsClass!}">
                    <input class="${properties.kcButtonClass!} ${properties.kcButtonPrimaryClass!} ${properties.kcButtonBlockClass!} ${properties.kcButtonLargeClass!}" type="submit" value="${msg("doRegister")}"/>
                </div>
            </div>

        </form>
    </#if>
</@layout.registrationLayout>
