from django.http.response import JsonResponse
from django.shortcuts import get_object_or_404, render
from .models import Blog
from django.utils import timezone
from django.views.decorators.csrf import csrf_exempt
import json



@csrf_exempt
def create(request):
    if request.method == 'POST':
        data = json.load(request)
        new_Blog = Blog()
        new_Blog.title = data["title"]
        new_Blog.writer = data["writer"]
        new_Blog.body = data["body"]
        new_Blog.pub_date= timezone.now()
        new_Blog.save()
        return JsonResponse({"message" : "create successfully", "blogid" : new_Blog.id, "title" : new_Blog.title, "writer" : new_Blog.writer, "body" : new_Blog.body})
    else:
        return JsonResponse({"message" : "fail"})

def detail(request, blogNumber):
    blog = get_object_or_404(Blog, pk=blogNumber)
    return JsonResponse({"title" : blog.title, "writer" : blog.writer, "body" : blog.body})

def list(request):
    recent = Blog.objects.all().order_by('id')
    bloglist = []

    for blog in recent:
        bloglist.append({})
        bloglist[-1]['title'] = blog.title
        bloglist[-1]['writer'] = blog.writer
        bloglist[-1]['body'] = blog.body
        bloglist[-1]['pub_date'] = blog.pub_date
        
    return JsonResponse({"bloglist" : bloglist})

@csrf_exempt
def delete(request, blogNumber):
    if request.method == 'DELETE':
        blog = get_object_or_404(Blog, pk=blogNumber)
        blog.delete()
        return JsonResponse({"message" : "deleted successfully"})

@csrf_exempt
def update(request, blogNumber):
    if request.method == 'PUT':
        data = json.load(request)
        update_Blog = get_object_or_404(Blog, pk=blogNumber)
        update_Blog.title = data["title"]
        update_Blog.writer = data["writer"]
        update_Blog.body = data["body"]
        update_Blog.pub_date= timezone.now()
        update_Blog.save()
    return JsonResponse({"message" : "updatete successfully", "blogid" : update_Blog.id, "title" : update_Blog.title, "writer" : update_Blog.writer, "body" : update_Blog.body})

