from django.db import models

# Create your models here.

class Blog(models.Model):
    title = models.CharField(max_length=200, null=True)
    writer = models.CharField(max_length=100,null=True)
    pub_date = models.DateTimeField(null=True)
    body = models.TextField(null=True)

    def __str__(self):
        return self.title
