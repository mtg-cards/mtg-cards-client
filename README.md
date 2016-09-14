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

- Create a virtual host pointing to public/index.html as a host root
- Open browser with the virtual host address

#### Make a production app.js

    $ lein release

#### Nginx virtual host example

    server {
        listen 80;
        server_name mtg.localhost;
    
        root /var/www/mtg-cards-client/public;
        index index.html;      
    
        location / {
            try_files $uri $uri/ /index.html;
        }
    }


#### See it in action!

http://mtg.arturgajewski.com
