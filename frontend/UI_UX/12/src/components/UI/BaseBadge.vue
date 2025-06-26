<script setup>
import { computed } from 'vue'

const props = defineProps({
  variant: {
    type: String,
    default: 'success',
  },
})

const badgeClass = computed(() => {
  return {
    'badge-success': props.variant === 'success',
    'badge-number': props.variant === 'number',
  }
})
</script>

<template>
  <div :class="badgeClass">
    <slot>Badge</slot>
  </div>
</template>

<style scoped>
.badge-success {
	background-color: #22c55e;
	color: white;
	padding: 0.25rem 0.5rem;
	font-size: 0.675rem;
	border-radius: 9999px;
  width: fit-content;
  display: inline-block;
}

.badge-number {
	background-color: red;
	color: white;
	border-radius: 50%;
	padding: 0.25rem 0.5rem;
	font-size: 0.675rem;
  width: fit-content;
  display: inline-block;
}
</style>
