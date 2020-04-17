from elasticsearch import Elasticsearch
client = Elasticsearch('localhost')
print("What")

mappings = {
    'mappings':{
        'event':{
            'properties':{
                'id': {'type':'string', 'index':'not_analyzed'},
                #lowercases
                #splits on white space and punctuation
                #stems e.g farm farming farmed => farm
                'name':{'type':'string','analyzer':'english'},
                'description': {'type':'string','analyzer':'english'}
            }
        }
    }
}
client.indices.create(index = 'eventbrite', body=mappings)