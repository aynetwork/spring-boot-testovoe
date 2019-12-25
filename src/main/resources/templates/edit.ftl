<#import "common.ftl" as c>

<@c.page>

    <#if purchaseError??>
        <div class="alert alert-danger">
            ${purchaseError}
        </div>
    </#if>

    <form action="" method="post">
        <label for="name">
            Имя
        </label>
        <input type="text" class="form-control" value="${purchase.getName()}" name="name">
        <label for="lastname">
            Фамилия
        </label>
        <input type="text" class="form-control" value="${purchase.getLastname()}" name="lastname">
        <label for="age">
            Возраст
        </label>
        <input type="text" class="form-control" value="${purchase.getAge()}" name="age">
        <label for="count">
            Количество товара
        </label>
        <input type="text" class="form-control" value="${purchase.getCount()}" name="count">
        <label for="age">
            Сумма покупки
        </label>
        <input type="text" class="form-control" value="${purchase.getAmount()}" name="amount">

        <label for="creation_date">
            Дата покупки
        </label>
        <input readonly type="text" class="form-control" value="${purchase.getCreationDate()}" name="creation_date">

        <label for="creation_date">
            Содержимое покупки
        </label>
        <input type="hidden" name="purchase_id" value="${purchase.getPurchase().getId()}" />
        <input readonly type="text" class="form-control" value="${purchase.getPurchase().getName()}" name="creation_date">
        <input class="btn btn-primary mt-2 float-right" type="submit">
    </form>
</@c.page>