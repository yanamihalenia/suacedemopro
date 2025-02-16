## Test case 1: Check filter on products page
    1. Залогиниться на сайт SauceDemo
    2. Отфильтровать товар по 'Name (A-Z)'
        ER: Список товаров отфильтрован по имени от A до Z
    3. Отфильтровать товар по 'Name (Z-A)'
        ER: Список товаров отфильтрован по имени от Z до A
    4. Отфильтровать товар по 'Price (low to high)'
        ER: Список товаров отфильтрован по цене от меньшей к большей
    5. Отфильтровать товар по 'Price (high to low)'
        ER: Список товаров отфильтрован по цене от большей к меньшей

## Test case 2: Make an order
    1. Залогиниться на сайт SauceDemo
    2. Добавить один товар в корзину
    3. Перейти в корзину
    4. Кликнуть Checkout
    5. Заполнить First name
    6. Заполнить Last name
    7. Заполнить Zip/Postal code
    8. Кликнуть Continue
    9. Кликнуть Finish
    10. Проверить, что заказ принят

## Test case 3: Check Total price of items
    1. Залогиниться на сайт SauceDemo
    2. Добавить 'Sauce Labs Onesie' и 'Sauce Labs Bolt T-Shirt' в корзину
    3. Перейти на старницу Checkout: Overview
    4. Проверить, что Item total равно сумме цен выбранных товаров

## Test case 4: Check Total price with tax
    1. Залогиниться на сайт SauceDemo
    2. Добавить 'Sauce Labs Onesie' и 'Sauce Labs Bolt T-Shirt' в корзину
    3. Перейти на старницу Checkout: Overview
    4. Проверить, что Total равно сумме Item total и Tax

## Test case 5: 'Cancel' button links user to Products page
    1. Залогиниться на сайт SauceDemo
    2. Добавить один товар в корзину
    3. Перейти на старницу Checkout: Overview
    4. Кликнуть 'Cancel'
    5. Проверить, что пользователь перенаправлен на страницу Products