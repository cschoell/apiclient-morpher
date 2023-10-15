# ApiClientMorpher 

This project aims to improve the interoperability between different api clients (like postman / hoppscotch / bruno / insomnia etc.).
It provides a tool to convert the respective configurations between the clients.

The initial need is due to a conversion from Postman to Bruno https://www.usebruno.com/ being required.
Hence this is being implemented first.

## Architecture

The project allows to write / read the models of each api client.

After they have been read, they are mapped into a "generic" model, which then can be mapped into any of the target models.

The generic model can also be saved separately and uses as a general configuration. Since the generic model is file based, 
it can be stored in version control.
