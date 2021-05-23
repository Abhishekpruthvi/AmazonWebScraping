# AmazonWebScraping

This project deals with scraping data from amazon website using the product url which is something similar to the below url,

`"url":"https://www.amazon.in/Biotique-Honey-Refreshing-Foaming-150ml/dp/B00KCLZ6VU"`

where the product unique ID ASIN should be present, based on this url we fetch the page and extract the product details such as 
* Product Name
* Price
* Image url etc.

This project has 2 services.

## Service 1 : WebScrap

 This service is our entry point where it has a POST API which accept the Page Url.
 
 ## POST
 `http://localhost:8081/webscrap/url`
 
 Request Body :
 
 `{
    "url":"https://www.amazon.in/Biotique-Honey-Refreshing-Foaming-150ml/dp/B00KCLZ6VU"
  }`
  
 ## Service 2 : ScrapStore
 
 This service is called by Service 1 to store the extracted Data, I have used elasticsearch to store the extracted data from the page.
 It has the API which accepts the RequestDto and store it in the elastic search.
 
 ## POST
 `http://localhost:8082/store`
 
 Request Body
 
 ```
 {
    "productName": "Ariel Matic 3in1 PODs Liquid Detergent Pack 18 Count for Both Front Load and Top Load Washing Machines",
    "imageUrl": "https://images-eu.ssl-images-amazon.com/images/I/519b5Ie-1SL._SX300_SY300_QL70_ML2_.jpg",
    "numberOfReviews": "963 ratings",
    "mrp": "₹ 432.00",
    "price": "₹ 324.00",
    "description": "Newly launched one-dose detergent capsules Ariel 3in1 PODs has 3 unique chambers that work had to clean, lift stains and brighten clothes Ariel 3in1 PODs can be used in any fully automatic machine. To use, place the Pod in the empty drum of the machine. Load the clothes and wash away those tough stains! 1 POD is enough for normal load. For heavy/large load, please use 2 PODs Ariel PODs will dissolve on their own in the wash. Please don't cut/ peel for use Item Weight: 357.0 Grams; Unit Count Type: Count"
}
```

The Data will be stored in the elasticsearch DB , we can call the below API to see all the stored data.

`curl -XGET "http://localhost:9200/seller_app/_search?pretty=true"`

**These 2 services are dockerized along with elasticsearch DB**

## How to RUN

Install Docker

Pull the project

Checkout master branch

Change the directory

**cd Docker**

We should be able to locate docker-compose.yml file.

Now just run **docker-compose up**

Now we can hit the service 1 API.






