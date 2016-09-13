# Magic: The Gathering - Card Search

Card search application built with ClojureScript and Reagent.

Data is fetched from external API @ magicthegathering.io and card photos provided by Gatherer @ gatherer.wizards.com .

#### Architecture

When you load the app, router matches requested uri to a page component. Matched route can also trigger actions.

All pages are state aware. Components use only passed properties and modify state by calling actions. 

Actions modify application state which propagates to all affected components.


               +----------------------------------+
               |                                  |
               |                                  +
    Core --+ Router --+ Page --+ Component --+ Action --+ State --+ 
                          +                                       | 
                          |                                       | 
                          +---------------------------------------+

#### Requirements

1. Install Leiningen
2. Install Java SDK 8 or later

#### Code with hot reloading

    $ lein figwheel

Open your browser at http://localhost:3450

#### Create self-contained package

    $ lein uberjar
    
    $ java -jar mtg-cards.jar

Fire up your browser at http://localhost:3001 and kaboom!

#### Nginx proxy

    upstream mtg-cards-upstream {
        server 127.0.0.1:3001;
    }
    
    server {
        listen 80;
        server_name example.org www.example.org;
    
        location / {
            proxy_pass http://mtg-cards-upstream;
        }
    }

#### See it in action!

http://mtg.arturgajewski.com

